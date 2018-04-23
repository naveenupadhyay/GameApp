package com.jungleegames.auxiliary.event.framework;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.jungleegames.auxiliary.database.entity.Table;
import com.jungleegames.auxiliary.event.GameStartEvent;
import com.jungleegames.auxiliary.event.framework.EventDispatcher;
import com.jungleegames.auxiliary.event.handler.GameStartedEventHandler;

/**
 * Event Dispatcher unit tests to assert and verify correct event dispatcher behaviour
 */
public class EventDispatcherTest {

  /**
   * This unit test should register events and event handlers correctly with the event dispatcher
   * and events should be dispatched accordingly.
   */
  @Test
  public void testEventDriverPattern() {

    EventDispatcher dispatcher = spy(new EventDispatcher());
    GameStartedEventHandler gameStartedEventHandler = spy(new GameStartedEventHandler());
    dispatcher.registerHandler(GameStartEvent.class, gameStartedEventHandler);

    Table table = new Table("PlayTable");

    GameStartEvent event = new GameStartEvent(table);
    //fire a GameStartEvent and verify that userCreatedEventHandler has been invoked.
    dispatcher.dispatch(event);
    verify(gameStartedEventHandler).onEvent(event);
    verify(dispatcher).dispatch(event);

  }

}
