// Trong module api.js
import axios from 'axios';
import Cookies from 'universal-cookie';
const API_URL = 'http://localhost:8080/api';
const cookies = new Cookies();

const api = axios.create({
  baseURL: API_URL,
});

// Thêm một interceptor để thiết lập token trong tiêu đề Authorization
api.interceptors.request.use(
  (config) => {
    const token = cookies.get('token');
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

export const getAllCourses = async (data) => {

}
export default api;