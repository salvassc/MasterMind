package santaTecla.utils;

public abstract class Command {
    
    protected String title;

    protected Command(String title) {
        this.title = title;
    }

    String getTitle() {
        return this.title;
    }

    public abstract boolean isActive();
    
    protected abstract void execute();
    
}
