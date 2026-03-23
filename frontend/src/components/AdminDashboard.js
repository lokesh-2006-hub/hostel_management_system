import React, { useState, useEffect } from 'react';
import { getRooms } from '../services/api';
import { useNavigate } from 'react-router-dom';

const AdminDashboard = ({ user, onLogout }) => {
  const [rooms, setRooms] = useState([]);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    if (!user || user.role !== 'ADMIN') {
      navigate('/login');
    } else {
      fetchRooms();
    }
  }, [user, navigate]);

  const fetchRooms = async () => {
    try {
      const response = await getRooms();
      if (response.success) {
        setRooms(response.data);
      } else {
        setError(response.message);
      }
    } catch (err) {
      setError(err.message || 'An error occurred while fetching rooms.');
    }
  };

  return (
    <div>
      <h1>Welcome, {user.username}</h1>
      <button onClick={onLogout}>Logout</button>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      <h2>Rooms</h2>
      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {rooms.map(room => (
            <tr key={room.id}>
              <td>{room.id}</td>
              <td>{room.name}</td>
              <td>{room.description}</td>
              <td>{room.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AdminDashboard;