[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8186949&assignment_repo_type=AssignmentRepo)
# Exercício Zoológico - Polimorfismo

Este exercício é uma continuação do exercício anterior do Zoológico, no qual havíamos trabalhado o conceito de herança.

Nosso objetivo será entender melhor os conceitos relacionados ao polimorfismo e melhorar a modelagem de nossas classes, adotando tais conceitos.

## Passo 1 - Continuando a partir do exercício anterior

Baixe o repositório do exercício anterior do Zoológico, e copie os arquivos da pasta `src` para a pasta `src` deste projeto.

Execute o programa e teste para confirmar que não ficou faltando nenhum arquivo.

Faça um commit com essas alterações, usando a mensagem: "Código do exercício anterior".

## Passo 2 - Experimentando Polimorfismo 1

Vamos começar exercitando nosso entendimento sobre os conceitos de polimorfismo.
Para isso, crie uma classe `Teste` com um método `main` e, dentro dele, faça o seguinte:

- Declare uma variável chamada `animal` do tipo `Animal` e atribua a ela um objeto da classe `Lobo`.
- Chame o método `getNome` usando a variável `animal`.
- Agora, usando a mesma variável `animal`, atribua a ela um objeto da classe `Galinha`.
- Chame o método `getNome` usando a variável criada.

Explique abaixo como é possível que a mesma variável `animal` possa ser usada para chamar métodos de objetos de classes diferentes.

R: Isso ocorre graças a hierarquia de herança, que permite uma variável de um tipo possa referenciar objetos de um subtipo, Assim a classe pai(Animal) pode referenciar objetos das classes filhas(Lobo,Galinha),e também, por cause de a variável animal ser polimórfica, ou seja, ela tem tipos dinâmicos diferentes em momentos diferentes.


Ao terminar, faça um commit com as alterações da classe `Teste` e as alterações neste arquivo README).

## Passo 3 - Experimentando Polimorfismo 2

Agora, altere o método `main` da classe `Teste` e faça o seguinte:
- Usando a mesma variável `animal` declarada no passo anterior, atribua a ela um objeto da classe `Lobo`.
- Chame o método `getDescricaoLonga` usando a variável `animal`.

O que é exibido?

  Groth é um(a) lobo que faz auu e tem pelo cinza.

O método chamado pertence a qual classe?

  Pertence a classe mamífero.

Agora usando a mesma variável `animal`, atribua a ela um objeto da classe `Galinha`.
- Chame o método `getDescricaoLonga` usando a variável criada.

O que é exibido?

  Jertrudes é um(a) Galinha que faz cocorico e não voa bem.

O método chamado pertence a qual classe?

  Pertence a classe ave.

Explique como a mesma linha de código `animal.getDescricaoLonga()` pode ser usada para chamar métodos de classes diferentes.

  Devido a variável ser polimórfica(pode assumir “formas” diferentes) e possuir tipos dinâmicos, ela referencia objetos de subclasses diferentes em diferentes momentos.


Ao terminar, faça um novo commit com as alterações (na classe Teste e neste arquivo README).

## Passo 4 - Usando Polimorfismo no Projeto Zoologico

Vamos agora perceber como o polimorfismo ajuda a reduzir a replicação de código. 

Para isso, você deve alterar a classe `Zoologico`:

- Substitua as listas de animais de cada espécie por uma única lista de animais.
- E, devido a essa modificação, implemente as alterações necessárias nos métodos da classe.

Do ponto de vista do usuário, seu programa deverá continuar funcionando da mesma forma que você havia feito no exercício da aula anterior, mas agora com um código melhor.

Teste suas alterações!

Ao final, faça um novo commit no seu repositório.

## Passo 5 - Identificando o uso de Polimorfismo

Para todas as perguntas abaixo, você deve indicar em qual classe e qual é o número da linha onde cada situação acontece.

1. Indique pelo menos uma variável polimórfica utilizada no seu código e explique porque ela é uma variável polimórfica.

Classe: zoologico

Linha: 9

Variável: animais

Explicação: animais é um array da super classe Animal, que pode possuir animais de espécies diferentes dentro
do array, ou seja, referencia diferentes objetos de diferentes sub classes em momentos distintos.(Visto que uma variável dinâmica da super classe pode referenciar objetos de suas sub classes)


2. Identifique algum ponto no código onde está sendo usado o princípio da substituição e explique o que é este princípio.

Classe: zoologico

Linha: 91

Explicação: O princípio da substituição consiste na possibilidade de usar um objeto de uma subclasse onde
um objeto da superclasse é esperado, ou seja, em substituição a ele. Nesse caso, na linha 91 a variável a é 
esperado um objeto da classe animal, quando na verdade são objetos das sub classes(Lobo,Gato,Galinha e Aguia).


3. Identifique algum ponto no código onde uma variável tem tipo estático e tipo dinâmico diferentes (indique quais são os tipos estático e dinâmico da variável neste ponto).

Classe: zoologico

Linha: 39

Variável: lobo

Tipo estático: Animal

Tipo dinâmico: Lobo


4. Identifique onde ocorre uma chamada de método que utiliza o polimorfismo de método.

Classe: zoologico

Linha: 120

