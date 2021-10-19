package java;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonRootName("ListaDePessoas")
public class ListaDePessoas implements Serializable {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Pessoa")
    List<Pessoa> pessoas;

    public ListaDePessoas(){
        super();
        this.pessoas = new ArrayList<>();
    }

    public ListaDePessoas(Pessoa ...pessoas){
        super();
        this.pessoas = new ArrayList<>();

        for (Pessoa p:pessoas) {
            this.pessoas.add(p);
        }
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
