package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {
    @Test
    public void whenMoveThenFigureNotFoundException() {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class,
                () -> logic.move(Cell.C1, Cell.H6));
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenImpossibleMoveException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> logic.move(Cell.C8, Cell.C6));
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C8 to C6.");
    }

    @Test
    public void whenMoveThenOccupiedCellException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new PawnBlack(Cell.D7));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class,
                () -> logic.move(Cell.C8, Cell.H3));
        assertThat(exception.getMessage()).isEqualTo("Occupied cell on the board.");
    }
}