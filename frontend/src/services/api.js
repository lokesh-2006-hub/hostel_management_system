import axios from 'axios';

const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';

const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// User Authentication
export const login = async (credentials) => {
  try {
    const response = await apiClient.post('/auth/login', credentials);
    return response.data;
  } catch (error) {
    throw error.response ? error.response.data : error.message;
  }
};

export const register = async (userData) => {
  try {
    const response = await apiClient.post('/auth/register', userData);
    return response.data;
  } catch (error) {
    throw error.response ? error.response.data : error.message;
  }
};

// Room Management
export const getRooms = async () => {
  try {
    const response = await apiClient.get('/rooms');
    return response.data;
  } catch (error) {
    throw error.response ? error.response.data : error.message;
  }
};

export const allocateRoom = async (allocationData) => {
  try {
    const response = await apiClient.post('/room_allocation', allocationData);
    return response.data;
  } catch (error) {
    throw error.response ? error.response.data : error.message;
  }
};

// Complaint Management
export const getComplaintsForStudent = async (studentId) => {
  try {
    const response = await apiClient.get(`/student/${studentId}/complaints`);
    return response.data;
  } catch (error) {
    throw error.response ? error.response.data : error.message;
  }
};