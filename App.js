import { BrowserRouter, Routes, Route } from 'react-router-dom';
import RegisterLogin from './RegisterLogin';
import WelcomeDashboard from './WelcomeDashboard';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<RegisterLogin />} />
        <Route path="/dashboard" element={<WelcomeDashboard />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
