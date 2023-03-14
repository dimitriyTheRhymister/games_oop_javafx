package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;

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

//    @Test
//    public void whenMoveThenImpossibleMoveException() {
//        Logic logic = new Logic();
//        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
//                () -> logic.move(Cell.C1, Cell.C6));
//        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to C6.");
//    }
//
//    @Test
//    public void whenMoveThenOccupiedCellException() {
//        Logic logic = new Logic();
//        OccupiedCellException exception = assertThrows(OccupiedCellException.class,
//                () -> logic.move(Cell.C1, Cell.C1));
//        assertThat(exception.getMessage()).isEqualTo("Occupied cell on the board.");
//    }
}