import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const RegisterLogin = () => {
  const [formData, setFormData] = useState({ fullName: '', email: '', password: '' });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({...formData, [e.target.name]: e.target.value });
  };

  const handleRegister = async () => {
    try {
      const res = await axios.post('http://localhost:8080/api/users/register', formData);
      localStorage.setItem("user", JSON.stringify(res.data));
      navigate('/dashboard');
    } catch (err) {
      alert(err.response?.data || "Register failed");
    }
  };

  const handleLogin = async () => {
    try {
      const res = await axios.post('http://localhost:8080/api/users/login', {
        email: formData.email,
        password: formData.password
      });
      localStorage.setItem("user", JSON.stringify(res.data));
      navigate('/dashboard');
    } catch (err) {
      alert(err.response?.data || "Login failed");
    }
  };

  return (
    <div className="form-container">
      <h2>Welcome Dashboard</h2>
      <input name="fullName" placeholder="Full Name" onChange={handleChange} />
      <br></br>
      <input name="email" placeholder="Email ID" onChange={handleChange} />
      <br></br>
      <input name="password" type="password" placeholder="Password" onChange={handleChange} />
      <br></br>
      <button onClick={handleRegister}>Register</button>
      <br></br>
      <button onClick={handleLogin}>Login</button>
    </div>
  );
};

export default RegisterLogin;
