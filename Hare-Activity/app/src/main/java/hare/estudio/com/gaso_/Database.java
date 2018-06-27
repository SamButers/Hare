package hare.estudio.com.gaso_;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HareDB";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_GASOLINA = "gasolina";
    private static final String COLUNA_ENDEREÇO = "endereço";
    private static final String COLUNA_ID = "Id";
    private static final String TABELA_POSTO = "tb_posto";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String QUERY_COLUNA = "CREATE TABLE " + TABELA_POSTO +"("
            + COLUNA_ID + " INTEGER PRIMARY KEY, " + COLUNA_NOME + " TEXT, "
            + COLUNA_GASOLINA + " TEXT, " + COLUNA_ENDEREÇO + " TEXT) ";

    db.execSQL(QUERY_COLUNA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    /* MALANDRAGEM FEIA DAQUI PRA BAIXO */

    void addposto (Posto posto){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUNA_ENDEREÇO,posto.getEndereço());
        values.put(COLUNA_GASOLINA,posto.getGasolina());
        values.put(COLUNA_NOME,posto.getNome());

        db.insert(TABELA_POSTO, null, values);
        db.close();

    }

    public List<Posto> listatodospostos(){

           List<Posto> listaPosto = new ArrayList<Posto>();

           String query = "SELECT * FROM " + TABELA_POSTO;

           SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
                do{
                    Posto posto= new Posto();
                    posto.setId(Integer.parseInt(c.getString(0)));
                    posto.setNome(c.getString(1));
                    posto.setGasolina(c.getString(2));
                    posto.setEndereço(c.getString(3));

                    listaPosto.add(posto);
                }while(c.moveToNext());
        }
        return listaPosto;
    }


}
