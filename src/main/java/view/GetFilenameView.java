package view;


public class GetFilenameView extends UserInputView {

    public static enum FileMode {
        Open, Close;
    }

    private String filename;
    private FileMode fileMode;


    public GetFilenameView(FileMode mode){
        fileMode = mode;
    }

    public boolean hasFilename(){
        return filename != null && filename.trim().length() > 0;
    }

    public String getFilename(){
        return filename;
    }



    @Override
    public UserInputItem[] getUserInputItems() {

        String operation = (fileMode == FileMode.Open ? "load" : "save");
        return new UserInputItem[] {
            new UserInputItem("Enter the file to " + operation + ":")
        };
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean doAction(String[] inputs) {
        filename = inputs[0];
        return false;
    }

}