package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {
    @Test
    void position() {
        Cell cell = Cell.F7;
        BishopBlack bishopBlack = new BishopBlack(cell);
        Cell exp = Cell.F7;
        assertEquals(bishopBlack.position(), exp);
    }

    @Test
    void copy() {
        Cell cell = Cell.F7;
        BishopBlack bishopBlack = new BishopBlack(cell);
        Figure exp = bishopBlack.copy(cell);
        assertEquals(bishopBlack.position(), exp.position());
    }

    @Test
    void way() {
        Cell cell = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(cell);
        Cell[] arrWayRsl = bishopBlack.way(Cell.G5);
        Cell[] arrExp = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        boolean rsl = Arrays.equals(arrWayRsl, arrExp);
        assertThat(rsl).isTrue();
    }

    @Test
    void whenIsDiagonalValid() {
        Cell cellS = Cell.C1;
        Cell cellD = Cell.G5;
        BishopBlack bishopBlack = new BishopBlack(cellS);
        boolean rsl = bishopBlack.isDiagonal(cellS, cellD);
        assertThat(rsl).isTrue();
    }

    @Test
    void whenIsDiagonalNoValid() {
        Cell cellS = Cell.C1;
        Cell cellD = Cell.C5;
        BishopBlack bishopBlack = new BishopBlack(cellS);
        boolean rsl = bishopBlack.isDiagonal(cellS, cellD);
        assertThat(rsl).isFalse();
    }

    @Test
    void whenMoveImpossibleMoveException() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    BishopBlack bishopBlack = new BishopBlack(Cell.C1);
                    bishopBlack.way(Cell.C5);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to C5.");
    }
}