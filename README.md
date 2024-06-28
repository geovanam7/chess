# Jogo de Xadrez

## Visão Geral

Este projeto implementa um jogo de xadrez em Java. Utiliza princípios de programação orientada a objetos (POO) para estruturar o código de forma clara e modular. Além das regras básicas do xadrez, o jogo também suporta jogadas especiais como roque, promoção de peão e en passant.

## Funcionalidades

- Jogo de xadrez completo com todas as regras oficiais.
- Suporte a jogadas especiais:
  - Roque
  - Promoção de peão
  - En passant
- Verificação de xeque e xeque-mate.
- Troca de turnos entre jogadores.
- Validação de movimentos.

## Tópicos de Programação Orientada a Objetos

### 1. Classes e Objetos

O projeto é estruturado em várias classes que representam diferentes entidades do jogo de xadrez, como peças, tabuleiro e posições.

- **Classe `ChessMatch`**: Controla o fluxo do jogo, gerencia turnos, verifica xeque e xeque-mate, e lida com jogadas especiais.
- **Classe `Board`**: Representa o tabuleiro de xadrez e gerencia as peças colocadas nele.
- **Classe `Piece`**: Classe base para todas as peças de xadrez.
- **Classes derivadas de `Piece`**: `King`, `Queen`, `Rook`, `Bishop`, `Knight`, `Pawn` - Cada uma representa um tipo específico de peça de xadrez com seus próprios movimentos.

### 2. Encapsulamento

O encapsulamento é usado para proteger os dados e garantir que apenas métodos específicos possam acessar e modificar o estado dos objetos.

- **Atributos privados**: Muitos atributos são privados e acessados por métodos públicos (getters e setters), garantindo que a lógica interna seja mantida e evitando modificações não autorizadas.

### 3. Herança

A herança é usada para criar uma hierarquia de classes que permite a reutilização de código comum.

- **Classe `Piece`**: É a superclasse para todas as peças de xadrez. Cada tipo de peça (como `King`, `Queen`, etc.) herda da classe `Piece` e implementa seus movimentos específicos.

### 4. Polimorfismo

O polimorfismo permite que métodos em diferentes classes derivadas sejam chamados através da interface da superclasse.

- **Método `possibleMoves`**: Cada classe de peça implementa sua versão do método `possibleMoves`, permitindo que o código que chama esse método não precise saber o tipo específico da peça.

## Jogadas Especiais

### Roque

O roque é uma jogada especial que envolve o rei e uma das torres. Existem duas formas de roque: o roque do lado do rei e o roque do lado da dama.

- **Regras para roque**:
  - Nenhuma das peças (rei e torre) deve ter se movido anteriormente.
  - Nenhuma peça pode estar entre o rei e a torre.
  - O rei não pode estar em xeque, passar por uma casa ameaçada ou terminar em xeque.

### Promoção de Peão

Quando um peão atinge a oitava linha do tabuleiro, ele pode ser promovido a qualquer outra peça (exceto o rei). A promoção mais comum é para uma rainha.

- **Regras para promoção**:
  - O peão deve alcançar a última linha.
  - A promoção pode ser feita para rainha, torre, bispo ou cavalo.

### En Passant

O en passant é uma jogada especial que permite que um peão capture outro peão que tenha avançado duas casas a partir de sua posição inicial.

- **Regras para en passant**:
  - Deve ser feito imediatamente após o peão adversário avançar duas casas.
  - O peão capturador deve estar na mesma linha que o peão capturado.

## Estrutura do Projeto

- `src/boardGame/Board.java`: Classe que representa o tabuleiro de xadrez.
- `src/boardGame/Piece.java`: Classe base para todas as peças.
- `src/boardGame/Position.java`: Classe que representa uma posição no tabuleiro.
- `src/boardGame/chess_System/ChessMatch.java`: Classe que gerencia o andamento do jogo.
- `src/boardGame/chess_System/ChessPiece.java`: Classe base para peças de xadrez com funcionalidades adicionais.
- `src/boardGame/chess_System/ChessPosition.java`: Classe que traduz coordenadas do tabuleiro de xadrez para posições internas.
