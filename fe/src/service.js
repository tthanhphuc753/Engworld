// Trong module api.js
import axios from 'axios';
import Cookies from 'universal-cookie';

const API_URL = 'http://localhost:8080/api';
const cookies = new Cookies()
const api = axios.create({
  baseURL: API_URL,
});

// Thêm một interceptor để thiết lập token trong tiêu đề Authorization
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export const register = async (data) => {
  try {
    const response = await api.post('/auth/register', data);
    return response.data;
  } catch (error) {
    throw new Error(error.response.data.message);
  }
};

export const authenticate = async (data) => {
  try {
    const response = await api.post('/auth/authenticate', data);
    return response.data;
  } catch (error) {
    throw new Error(error.response.data.message);
  }
};

export const getAllUser = async () => {
  try {
    const token = cookies.get('token')
    const response = await api.get('/admin/user/getAll', {
      headers: {
        Authorization: `Bearer ${token}` // Attach token in the Authorization header
      }
    })
    return response.data
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}

export const getAllCourses = async () => {
  try {
    const token = cookies.get('token')
    const response = await api.get('/admin/courses/get', {
      headers: {
        Authorization: `Bearer ${token}` // Attach token in the Authorization header
      }
    })
    return response.data
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}

export const getAllQuestion = async () => {
  try {
    const token = cookies.get('token')
    const response = await api.get('/admin/question/get', {
      headers: {
        Authorization: `Bearer ${token}` // Attach token in the Authorization header
      }
    })
    return response.data.data
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}
export const userGetAllQuestion = async () => {
  try {
    const response = await api.get('/client/question/get')
    const questions = {
      content: response.data.data.content.map((question)=>{
        return {
          questionId: question.questionId,
          questionText: question.questionText,
          options: [question.op1, question.op2, question.op3, question.correctAnswer].sort(() => Math.random() - 0.5) ,
          correctAnswer: question.correctAnswer,
          explanation: "chưa có",
        }
      }),
      length: response.data.data.content.length
    }
    
    console.log("question:" ,questions)
    return questions
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}

export const deleteQuestion = () =>{

}

export const uploadQuestionsFile = () => {

}

export const getAllVocabulary = async () => {
  try {
    const token = cookies.get('token')
    const response = await api.get('/admin/vocab/get', {
      headers: {
        Authorization: `Bearer ${token}` // Attach token in the Authorization header
      }
    })
    return response.data
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}

export const deleteVocabulary = async (id) => {
  try {
    const token = cookies.get('token')
    axios.defaults.withCredentials = true;
    const response = await api.delete(`/admin/vocab/delete?id=${id}`, {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}` // Attach token in the Authorization header
      }
    })
    return response.data
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}

export const uploadVocabFile = async () => {

}

export const getAllCourse = () => {

}

export const uploadCoursesFile = () => {

}

export const deleteCourse = () => {

}

export const clientGetAllCourses = async () =>{
  try {
    const response = await api.get(`/client/courses/get`,{
      headers: {
        'Content-Type': 'application/json',
      }
    })
    return response.data
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}

export const clientGetCourse = async (id) => {
  try {
    const response = await api.get(`/client/courses/${id}`)
    return response.data
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}

export const clientGetAllTests = async () => {
  try {
    const response = await api.get(`/client/exercise/get`)
    return response.data
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}

export const clientGetTest = async (id) => {
  try {
    const response = await api.get(`/client/question/byEx?exId=${id}`)
    
    const questions = {
      content: response.data.data.content.map((question)=>{
        return {
          questionId: question.questionId,
          questionText: question.questionText,
          options: [question.op1, question.op2, question.op3, question.correctAnswer].sort(() => Math.random() - 0.5) ,
          correctAnswer: question.correctAnswer,
        }
      }),
      length: response.data.data.content.length
    }
    return questions
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}

export const clientGetVideoByCourse = async (id) => {
  try {
    const response = await api.get(`/client/video/byCourse/${id}`)
    console.log(response)
    return response.data
  } catch (error) {
    throw new Error(error.response.data.message)
  }
}
export default api;