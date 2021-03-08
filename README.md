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

# MÉTODO GET PESQUISAR CLIENTE PELO CPF 

http://34.71.7.57:8080/sistema-vendas/findClientCPF/aquivaiocpfsempontoetraços

# MÉTODO GET PESQUISAR CLIENTE PELO EMAIL 

http://34.71.7.57:8080/sistema-vendas/findClient/aquivaioemail

# MÉTODO GET PESQUISAR CLIENTE PELO ID 

http://34.71.7.57:8080/sistema-vendas/findUserID/aquivaioID

# MÉTODO DELETE DELETAR CLIENTE PELO ID 

http://34.71.7.57:8080/sistema-vendas/deleteUser/aquivaioID

>>>>>>> 9ae94afbd194223072982caaba0b974a31b0a673
