# AppGestaoTarefas

### Aplicação para gerenciar sessão de votação
- Cadastrar uma nova pauta; 
- Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo 
  determinado na chamada de abertura ou 1 minuto por default); 
- Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é 
  identificado por um id único e pode votar apenas uma vez por pauta); 
- Contabilizar os votos e dar o resultado da votação na pauta. 

### Tecnologias e ferramentas utilizadas:
- `IntelliJ IDEA 2022.1.3 (Community Edition)`
- `Spring`
- `Hibernate (JPA)`
- `PosgreSQL`
- `Servidor Apache Tomcat v8.0`
- `Swagger 2.7.0`
- `Gradle

<br>

## Como executá-lo

Clone ou faça [download](https://github.com/amandaolmr/sistemaVotacao) deste projeto e do projeto de validar o CPF [download](https://github.com/amandaolmr/valida-cpf), 
vá para a implementação do servidor de sua escolha e siga as instruções README.

1 - Importe o projeto em uma IDE de sua preferência<br>
2 - Execute o servidor do projeto valida-cpf porta: 9002 <br>
3 - Execute o servidor do projeto sistemaVotacao porta: 9001 <br>
3 - Abra o swegger (http://localhost:9001/swagger-ui.html) no browser de sua preferencia.

## Informações

Neste repositório, foi utilizado o padrão Layers(camadas):

## Observações importantes
Na integração com endpoint para validação de cpf foi realizado o mock de dois cpfs para fins de testes são eles:
07287376040 - Poderá realizar o voto e api retornará ABLE_TO_VOTE 
82502851076 - Não poderá votar e a api retornará UNABLE_TO_VOTE 
Os demais CPF validos terão liberação para votar normalmente. 
Caso queira testar sem a integração com a validação do cpf precisa comentar o código da classe PautaServiceImpl as linhas: 86,87,91,92.
