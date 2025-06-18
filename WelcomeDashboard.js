import React from 'react';
import { useNavigate } from 'react-router-dom';

const WelcomeDashboard = () => {
  const user = JSON.parse(localStorage.getItem("user"));
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("user");
    navigate("/");
  };

  if (!user) return <h2>Unauthorized</h2>;

  return (
    <div>
      <h2>Welcome, {user.fullName}</h2>
      <p>Email: {user.email}</p>
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
};

export default WelcomeDashboard;
