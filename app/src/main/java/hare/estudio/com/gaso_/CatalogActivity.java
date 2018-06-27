package hare.estudio.com.gaso_;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CatalogActivity extends AppCompatActivity {

    ListView listView;
    Database db= new Database(this);

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_catalog);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);

                listView= findViewById(R.id.listView);
                listarPostos();

                /* CRAAAAAAWLING IN MY SKIN*/

                db.addposto(new Posto("Petrobras","R$ 4.99","SIND QI 1"));
                db.addposto(new Posto("Iticar","R$ 4.50","ST LESTE IND QI 07"));
                db.addposto(new Posto("JB","R$ 5.60","Qd Q 10 - s/n KM22 ch 4 BR290, St. Leste Q 11"));
                db.addposto(new Posto("Êxito","R$ 4.50","SIND QI 5"));
                db.addposto(new Posto("Petrobras","R$ 3.99","PC 01 Lote 04 Setor Leste S/N, SIND"));
                db.addposto(new Posto("Petrogama","R$ 3.39","St. Central Q 46 "));
                db.addposto(new Posto("Alvorada","R$ 4.69","St. Leste Q 42"));
                db.addposto(new Posto("Best iii","R$ 3.99","St. Oeste EQ 3/5"));
                db.addposto(new Posto("Eldorado","R$ 4.19","Central 51/53 "));
                db.addposto(new Posto("Rodobelo","R$ 4.49","SH Ponte de Terra 7 - Pte. Alta Norte (Gama)"));



    }


    public void listarPostos(){
        List<Posto> postos = db.listatodospostos();
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(CatalogActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        for(Posto p : postos){
            arrayList.add(p.getNome()+"\n"+ p.getGasolina() +"\n"+ p.getEndereço() );
            adapter.notifyDataSetChanged();
        }
    }
}
