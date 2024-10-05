<center>

# BLOCKCHAIN DEMO

</center>

> Nesse breve resumo, irei falar sobre o que aprendi e achei interessante no conteúdo: *"Blockchain Demo"*, mais especificamente sobre o tema que o site mais acrescentou a minha aprendizagem que foi sobre como funciona arquitetura de rede de computadores **Peer-to-peer (P2P)**.

- [Link do site](https://blockchaindemo.io/ "blockchaindemo")

---

## Introdução

O *Peer-to-peer (P2P)* é a arquitetura de rede que a blockchain se baseia. É a partir dela que é possível um dos principais conceitos da blockchain: a **descentralização**

Ela permite o compartilhamento de dados sem a necessidade de um _servidor central_. Nesse modelo, cada computador, ou **nó**, da rede funciona como cliente e servidor, *cooperando com os demais*.

- [x] Os nós são conectados de forma aleatória.
- [x] Não há restrição sobre o número de nós que podem participar da rede.
- [x] Os nós são aproximadamente equivalentes.

Para manter a blockchain, cada nó guarda consigo uma **versão completa** da mesma. Para atualizar a blockchain, o nó deve verificar uma **diferença entre a blockchain em seu domínio e em posse de seu par (outro nó)**, seja em *tamanho* ou no *bloco mais recente*.

## Processo

- **Primeira etapa:**
    1. **O nó pede** o *bloco mais recente* ao seu par.
    2. **O nó verifica** se o *hash anterior do bloco enviado* é igual ao *hash do bloco mais recente da sua blockchain*.
       - **SIM**:
         1. Verifica se o bloco é válido.
         2. **Se válido**, coloca na sua blockchain e comunica a mudança a todos os seus pares.
         3. **Se não válido**, não faz nada.
       - **NÃO**:
         1. **Próxima etapa**.

- **Primeira etapa:**
    1. **O nó verifica** se o *index do bloco enviado* é maior que o *index do bloco mais recente da sua blockchain*. Em outras palavras, se a blockchain do par é maior que a sua própria blockchain.
       - **SIM**:
         1. Pede a blockchain inteira do par e verifica se ela é válida.
         2. **Se válido**, substitue a sua blockchain pela blockchain enviada pelo par e comunica a mudança a todos os seus pares.
         3. **Se não válido**, não faz nada.
       - **NÃO**:
         1. **Não faz nada**.

## Conclusão

Esse sistema **garante** que os nós sempre irão guardar a *maior e mais atualizada blockchain válida*.

Óbvio que por *cada nó estar conectado com uma quantidade limitada de par*, nem todos guardarão a blockchain correta e mais atualizada. Porém, com o passar do tempo, *esse sistema irá garantir* que cada **informação esteja presente na blockchain que cada nó guarda**.
