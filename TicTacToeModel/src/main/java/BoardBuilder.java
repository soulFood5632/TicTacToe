import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class BoardBuilder extends TypeAdapter<Board> {

    @Override
    public void write(JsonWriter out, Board value) throws IOException {

        out.beginObject();
        out.name("Board");
        out.beginArray();

            /*
            This serilization will
             */
        for(int index = 0; index < 9; index++){
            if(value.getBoard()[index] == GamePiece.X){
                out.value(1);
            } else if (value.getBoard()[index] == GamePiece.O){
                out.value(0);
            } else {
                out.value(-1);
            }
        }
        out.endArray();
        out.endObject();
    }

    @Override
    public Board read(JsonReader in) throws IOException {

        JsonToken token = in.peek();

        if (!token.equals(JsonToken.NAME)){
            throw new RuntimeException("error in read");
        }

        in.beginArray();

        GamePiece[] gamePieces = new GamePiece[9];

        for(int index = 0; index < 9; index++) {
            if(in.nextInt() == 1){
                gamePieces[index] = GamePiece.X;
            } else if (in.nextInt() == 0){
                gamePieces[index] = GamePiece.O;
            } else {
                in.nextInt();
                gamePieces[index] = null;
            }
            index++;
        }

        in.endArray();
        in.endObject();


        return new Board(gamePieces);
    }

}
