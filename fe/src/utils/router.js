export const ROUTERS = {
    USER: {
        HOME: '',
        TEST: 'test/:id',
        TESTS: 'tests',
        COURSES: 'courses',
        COURSEINFO: 'courseinfo/:id',
    },
    ADMIN: {
        HOME: '*',
    },
    AUTHEN: {
        LOGIN: 'login',
        REGISTER: 'register',
    }
}
