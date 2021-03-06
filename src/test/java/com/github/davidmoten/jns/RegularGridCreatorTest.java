package com.github.davidmoten.jns;

import static com.github.davidmoten.jns.TestingUtil.createMesh;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RegularGridCreatorTest {

    private static final double PRECISION = 0.00001;

    @Test
    public void testBottomOfRegularGridCellType() {
        Mesh grid = createMesh();
        Cell cell = grid.cell(5, 5, 0);
        assertEquals(CellType.FLUID, cell.type());
        assertEquals(CellType.FLUID, cell.up().type());
        assertEquals(CellType.OBSTACLE, cell.down().type());
        assertEquals(Util.SEA_LEVEL_PRESSURE_PASCALS, grid.cell(5, 5, 9).pressure(), PRECISION);
        assertEquals(Util.pressureAtDepth(1), grid.cell(5, 5, 8).pressure(), PRECISION);
        assertEquals(Util.pressureAtDepth(9), grid.cell(5, 5, 0).pressure(), PRECISION);
    }
}
