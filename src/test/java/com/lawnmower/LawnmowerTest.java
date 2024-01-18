package com.lawnmower;

import com.lawnmower.domain.Coordination;
import com.lawnmower.domain.Instruction;
import com.lawnmower.domain.Position;
import com.lawnmower.domain.Lawnmower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.lawnmower.domain.Instruction.*;
import static com.lawnmower.domain.Orientation.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LawnmowerTest {

    private Lawnmower lawnmower;

    @BeforeEach
    void setUp() {
        Coordination origin = new Coordination(0, 0, 5, 5);
        Position startPosition = new Position(origin, N);
        lawnmower = new Lawnmower(startPosition);
    }


    @Test
    void test_move_to_north() {
        lawnmower.executeInstructions(A);
        assertThat(lawnmower.getPosition().getY(), equalTo(1));
        assertThat(lawnmower.getPosition().getOrientation(), equalTo(N));
    }

    @Test
    void test_move_to_south() {
        lawnmower.executeInstructions(D,D,A);
        assertThat(lawnmower.getPosition().getY(), equalTo(0));
        assertThat(lawnmower.getPosition().getOrientation(), equalTo(S));
    }

    @Test
    void test_move_to_east() {
        Position position = lawnmower.getPosition();
        position.rotate(D);
        assertThat(position.getX(), equalTo(0));
        assertThat(position.getOrientation(), equalTo(E));
    }

    @Test
    void test_move_to_west() {
        Position position = lawnmower.executeInstructions(G,A);
        assertThat(position.getX(), equalTo(0));
        assertThat(position.getOrientation(), equalTo(W));
    }


    @Test
    void test_do_not_move_if_position_out_of_lawn() {
        lawnmower.executeInstructions(D,A, A, A, A, A, A);
        assertThat(lawnmower.getPosition().getX(), equalTo(5));
        assertThat(lawnmower.getPosition().getY(), equalTo(0));
        assertThat(lawnmower.getPosition().getOrientation(), equalTo(E));
    }

    @Test
    void test_throw_unexpected_operation_if_orientation_is_not_known() {
        Exception thrown = Assertions.assertThrows(UnsupportedOperationException.class, () -> lawnmower.executeInstructions(Instruction.UNKNOWN));
        assertThat(thrown.getMessage(), equalTo(Instruction.UNKNOWN.name() + "Is not a managed command"));
    }




}
