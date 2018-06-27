package com.dabsquared.giteejenkins.trigger.handler.note;

/**
 * @author Nikolay Ustinov
 */
public final class NoteHookTriggerHandlerFactory {

    private NoteHookTriggerHandlerFactory() {}

    public static NoteHookTriggerHandler newNoteHookTriggerHandler(boolean triggerOnNoteRequest, String noteRegex) {
        if (triggerOnNoteRequest) {
            return new NoteHookTriggerHandlerImpl(noteRegex);
        } else {
            return new NopNoteHookTriggerHandler();
        }
    }
}
