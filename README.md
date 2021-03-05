# MÉTODO GET LISTAR CLIENTES

http://34.71.7.57:8080/sistema-vendas/getAllClients

# MÉTODO POST CRIAR NOVO CLIENTE

Passar os parametros abaixo via Postman (recomendo usar um gerador de CPF como o https://www.geradordecpf.org)

{   
"name": "nome",
"email": "email",
"city": "cidade",
"cpf": "cpf válido"

}
http://34.71.7.57:8080/sistema-vendas/registerClient