import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import Alunos from './pages/Alunos';

const App: React.FC = () => {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/alunos" />} />
      <Route path="/alunos" element={<Alunos />} />
      {/* Adicione outras rotas conforme necessário */}
    </Routes>
  );
};

export default App;



