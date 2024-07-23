export const fetchAlunos = async () => {
    const response = await fetch('http://localhost:8080/api/alunos');
    if (!response.ok) {
      throw new Error('Erro ao buscar alunos');
    }
    return response.json();
  };
  