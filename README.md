# sistemaVotacao
Aplicação para gerenciar sessão de votação

Na integração com endpoint para validação de cpf foi realizado o mock de dois
cpfs para fins de testes são eles:
07287376040 - Poderá realizar o voto e api retornará ABLE_TO_VOTE
82502851076 - Não poderá votar e a api retornará UNABLE_TO_VOTE
Os demais CPF validos terão liberação para votar normalmente.
Caso queira testar sem a integração com a validação do cpf precisa comentar o código
da classe PautaServiceImpl as linhas: 86,87,91,92.
