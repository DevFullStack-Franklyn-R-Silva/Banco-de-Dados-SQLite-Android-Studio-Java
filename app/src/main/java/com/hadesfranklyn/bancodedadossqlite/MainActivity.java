package com.hadesfranklyn.bancodedadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
//            bancoDados.execSQL("DROP TABLE pessoas");

            //Inserir dados
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Franklyn', 24)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Carlos', 30)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Maria', 35)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Paulo', 35)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Ana', 50)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Pedro', 65)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Alex', 50)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Luiz', 51)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Roberto', 18)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Mariana', 18)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Mario', 18)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Silva', 18)");

            //Update do dados
            bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Mariana Silva'  WHERE nome = 'Mariana'");

            //Recuperar pessoas
//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                    "WHERE nome = 'Franklyn' AND idade = 24";
//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                    "WHERE idade >= 30 OR idade = 24";
//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                    "WHERE idade IN(24,30)";
//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                            "WHERE nome IN('Carlos','Franklyn')";
//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                            "WHERE idade BETWEEN 24 AND 35";
//            String filtro = "mar";
//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                            "WHERE nome LIKE '%" + filtro + "%'";
//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                            "WHERE 1=1 ORDER BY nome ASC";
//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                            "WHERE 1=1 ORDER BY idade DESC";
            String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE nome = 'Mariana Silva'";

            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //Indices da tabela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while (cursor != null) {

                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("Resultado - id" + id + " | nome: ", nome + " | idade: " + idade);

                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}