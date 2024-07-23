import React, { useState, useEffect } from 'react';
import { fetchAlunos } from '../service/api';
import { Container, Table } from 'react-bootstrap';
import { Aluno } from '../types/Aluno';

const Alunos: React.FC = () => {
  const [alunos, setAlunos] = useState<Aluno[]>([]);

  useEffect(() => {
    fetchAlunos()
      .then(data => setAlunos(data))
      .catch(err => console.error(err));
  }, []);

  return (
    <Container>
      <h1 className="my-4">Lista de Alunos</h1>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Nome</th>
            <th>CPF</th>
            <th>Email</th>
            <th>WhatsApp</th>
          </tr>
        </thead>
        <tbody>
          {alunos.map((aluno: Aluno) => (
            <tr key={aluno.cpf}>
              <td>{aluno.nome}</td>
              <td>{aluno.cpf}</td>
              <td>{aluno.email}</td>
              <td>{aluno.whatsapp}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Container>
  );
};

export default Alunos;
