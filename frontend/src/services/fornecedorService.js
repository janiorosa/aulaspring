//const API_URL = "http://localhost:8088/api/fornecedores";
const API_URL = "/api/fornecedores";

async function tratarResposta(response) {
  if (!response.ok) {
    const mensagem = await response.text();

    throw new Error(
      mensagem || `Erro na requisição: HTTP ${response.status}`
    );
  }

  return response.json();
}

export async function listarFornecedores() {
  const response = await fetch(API_URL);

  return tratarResposta(response);
}

export async function cadastrarFornecedor(fornecedor) {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(fornecedor),
  });

  return tratarResposta(response);
}