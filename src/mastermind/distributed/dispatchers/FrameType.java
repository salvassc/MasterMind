package mastermind.distributed.dispatchers;

public enum FrameType {
    START,
    STATE,
    UNDO,
    REDO,
    UNDOABLE,
    REDOABLE,
    NEW_GAME,
    CLOSE,
    PROPOSECOMBINATION,
    ISGAMEFINISHED,
    ATTEMPS,
    WHITES,
    BLACKS,
    WINNER,
    LOOSER,
    WIDTH,
    GETTITLE,
    SETTITLE,
    STARTNAME,
    TITLES,
    SAVE,
    SAVEDNAMED,
    NEXT,
    HASNAME,
    EXISTS;
    
    public static FrameType parser(String string) {
        for(FrameType frameType : FrameType.values()){
            if(frameType.name().equals(string)){
                return frameType;
            }
        }
        return null;
    }
    
}
