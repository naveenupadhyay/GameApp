/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.jungleegames.auxiliary.event.framework;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jungleegames.auxiliary.event.GameScheduledToStartEvent;
import com.jungleegames.auxiliary.event.GameStartEvent;
import com.jungleegames.auxiliary.event.JoinTableEvent;
import com.jungleegames.auxiliary.event.PlayerDisconnectEvent;
import com.jungleegames.auxiliary.event.handler.GameScheduledToStartEventHandler;
import com.jungleegames.auxiliary.event.handler.GameStartedEventHandler;
import com.jungleegames.auxiliary.event.handler.JoinTableEventHandler;
import com.jungleegames.auxiliary.event.handler.PlayerDisconnectedEventHandler;

/**
 * Handles the routing of {@link Event} messages to associated handlers.
 * A {@link HashMap} is used to store the association between events and their respective handlers.
 */
@Service("EventDispatcher")
public class EventDispatcher {

  private Map<Class<? extends Event>, Handler<? extends Event>> handlers = new HashMap<>();;
  
  @Autowired
  private JoinTableEventHandler joinTableEventHandler;
  
  @Autowired
  private GameScheduledToStartEventHandler gameScheduledToStartEventHandler;
  
  @Autowired
  private GameStartedEventHandler gameStartedEventHandler;
  
  @Autowired
  private PlayerDisconnectedEventHandler playerDisconnectEventHandler;

  public EventDispatcher() {
  }

  @PostConstruct
  public void init() {
	  this.registerHandler(JoinTableEvent.class, joinTableEventHandler);
	    this.registerHandler(GameScheduledToStartEvent.class, gameScheduledToStartEventHandler);
	    this.registerHandler(GameStartEvent.class, gameStartedEventHandler);
	    this.registerHandler(PlayerDisconnectEvent.class, playerDisconnectEventHandler);
  }
  /**
   * Links an {@link Event} to a specific {@link Handler}.
   *
   * @param eventType The {@link Event} to be registered
   * @param handler   The {@link Handler} that will be handling the {@link Event}
   */
  public <E extends Event> void registerHandler(Class<E> eventType,
                                                Handler<E> handler) {
    handlers.put(eventType, handler);
  }

  /**
   * Dispatches an {@link Event} depending on it's type.
   *
   * @param event The {@link Event} to be dispatched
   */
  @SuppressWarnings("unchecked")
  public <E extends Event> void dispatch(E event) {
    Handler<E> handler = (Handler<E>) handlers.get(event.getClass());
    if (handler != null) {
      handler.onEvent(event);
    }
  }

}