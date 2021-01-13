/*
 * Copyright (c) 2020 GeekShop.
 * All rights reserved.
 */

package io.geekshop.common.fsm;

import java.util.HashMap;
import java.util.List;

/**
 * A type which is used to define valid states and transitions for a state machine based on {@link FSM}.
 *
 * Created on Dec, 2020 by @author bobo
 */
public class Transitions<T> extends HashMap<T, List<T>> {
}
