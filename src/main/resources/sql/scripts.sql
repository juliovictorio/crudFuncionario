--cria��o do primeiro usuario para acesso ao sistema
--o login ser� julio@gmail.com com a senha 123456
Insert into ESTACIOCRUD.PESSOA (TIPO_PESSOA,ID,EMAIL,NOME,SENHA,DATA_ADMISSAO,MATRICULA,SALARIO,BONIFICACAO,FALA_INGLES,PERIODO_TRABALHO,ID_DEPARTAMENTO) values ('GERENTE','1','julio@gmail.com','Julio','e10adc3949ba59abbe56e057f20f883e',null,'234561','100','100','0','NOTURNO',null);


--Departamentos
insert into ESTACIOCRUD.DEPARTAMENTO VALUES(ESTACIOCRUD.IDENTITY_DEPARTAMENTO.NEXTVAL, 'VENDAS');
insert into ESTACIOCRUD.DEPARTAMENTO VALUES(ESTACIOCRUD.IDENTITY_DEPARTAMENTO.NEXTVAL, 'SECRETARIA');