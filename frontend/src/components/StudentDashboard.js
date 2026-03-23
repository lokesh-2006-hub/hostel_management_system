import React, { useState, useEffect } from 'react';
import { getRooms } from '../services/api';
import { useNavigate } from 'react-router-dom';

const StudentDashboard = ({ user, onLogout }) => {
  const [rooms, setRooms] = useState([]);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    if (!user) {
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
      <h1>Welcome, {user.username}!</h1>
      <button onClick={onLogout}>Logout</button>

      {error && <p style={{ color: 'red' }}>{error}</p>}

      <h2>Available Rooms</h2>
      <ul>
        {rooms.map(room => (
          <li key={room.id}>
            Room {room.number} - {room.type}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default StudentDashboard;