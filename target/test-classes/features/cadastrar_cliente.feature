#language: pt

@cliente
Funcionalidade: Cadastro de clientes
	Como um colaborador do banco bajax 
	Eu quero cadastrar clientes
	Para a criação de novas contas no banco
	
Cenário: deve criar cliente com sucesso
	Dado que possuo as informações válidas de um individuo
	Quando crio um cliente com essas informações
	Então o cliente é cadastrado com sucesso

Cenário: cliente inválido campos obrigatórios nulos
	Dado que possuo as informações para criar um cliente a partir da lista
	| nome      | email          | cpf          | ativo   |
	| Yuri Azul | yuri@gmail.com | 123456789-11 | true    |
	Quando adiciono um campo como nulo
	| nome      | email          | cpf          | ativo   |
	|           | yuri@gmail.com | 123456789-11 | true    |
	Então ao tentar criar o cliente recebo uma mensagem de erro
  