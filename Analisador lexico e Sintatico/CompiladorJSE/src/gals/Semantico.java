package gals;

import java.util.ArrayList;
import java.util.List;

public class Semantico implements Constants
{
    private VarMy varMy, varMyDuplicada, varMyTemporaria = new VarMy() , varMyTemporariaAtribuicao = new VarMy();
    private SemanticTable semanticTable = new SemanticTable();
    private int idLocal = 0;
    private boolean verificaDeclarada = false, tipoInput = false , tipoOutput = false, duplicada = false, primeiraVar = false;
    private List<VarMy> lista = new ArrayList<VarMy>(); // lista de minhas variaveis e seus estados
    private List<VarMy> listaVariaveisNDeclarada = new ArrayList<VarMy>(); //lista de variaveis não declaradas
    private List<VarMy> listaDuplicadas = new ArrayList<VarMy>(); //lista de variaveis duplicadas 
    private List<VerificaOperacoes> listVO = new ArrayList<VerificaOperacoes>();
            
    private VerificaOperacoes verificaOperacoes = new VerificaOperacoes();
            
    private int disparoLocal;
    
    public List<VarMy> getListaDuplicadas() {
        return listaDuplicadas;
    }
     
    public List<VarMy> getListaVariaveisNDeclarada() {
        return listaVariaveisNDeclarada;
    }

    public List<VarMy> getLista() {
        return lista;
    }
    
    public List<VerificaOperacoes> getListVO() {
        return listVO;
    }
    
    
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Meu Copilador: "+action+", Token: "+token.getLexeme());
        switch(action) {
            case 1 : 
                    //crio um contador para id das variaveis
                    varMy = new VarMy();
                    varMy.setId(idLocal); // seto id local e o tipo da variavel
                    varMy.setTipo(token.getLexeme());
                    if(token.getLexeme().equals("int")){
                        varMy.setTipoNumerico(semanticTable.INT);
                    }else{
                        if(token.getLexeme().equals("float")){
                            varMy.setTipoNumerico(semanticTable.FLO);
                        }else{
                            if(token.getLexeme().equals("string")){
                                varMy.setTipoNumerico(semanticTable.STR);
                            }
                        }
                    }
                    primeiraVar = true;
                    varMyTemporaria.setId(idLocal);
                    varMyTemporaria.setTipo(token.getLexeme());
                break;
            case 2 :
                    if(primeiraVar){
                        primeiraVar = false;
                        //chamando o id pelo copilador vou adicionar o nome da variavel e setar declarada como true
                        varMy.setNome(token.getLexeme());
                        varMy.setDeclarada(Boolean.TRUE);
                    }else{
                        //chamando o id pelo copilador vou adicionar o nome da variavel e setar declarada como true
                        varMy = new VarMy();
                        varMy.setId(varMyTemporaria.getId());
                        varMy.setTipo(varMyTemporaria.getTipo());
                        varMy.setNome(token.getLexeme());
                        varMy.setDeclarada(Boolean.TRUE);
                    }
                    
                    //aqui vou analisar se a variavel é duplicada
                    for (VarMy v: lista) {
                        if(v.getNome().equals(token.getLexeme())){
                           duplicada = true;     
                        }
                    }
                    if(!duplicada) {
                        lista.add(idLocal,varMy); //se não duplicada adiciono na lista
                        idLocal ++;
                    }else{//se duplicada vamos adicionar na lista de var duplicadas
                        idLocal --;
                        duplicada = false;
                        varMyDuplicada = new VarMy();
                        varMyDuplicada.setNome(token.getLexeme());
                        listaDuplicadas.add(varMyDuplicada);
                    }

                break;     
            case 3 :
                    if(token.getLexeme().equals("=")){
                        varMy.setInicializada(Boolean.TRUE);
                    }else{
                       // varMy = new VarMy();
                        for (VarMy v: lista) {
                            if(v.getNome().equals(token.getLexeme())){
                                v.setInicializada(Boolean.TRUE);
                                varMyTemporariaAtribuicao = v;
                                //varMy = v;
                            }  
                        }
                        //lista.add(varMy.getId(), varMy);
                    }
                break;     
            case 4 :
                verificaDeclarada = false;
                   //varMy = new VarMy();
                if(tipoInput){
                   tipoInput = false;
                   for (VarMy v: lista) {
                        if(v.getNome().equals(token.getLexeme())){
                            v.setInicializada(Boolean.TRUE);
                            verificaDeclarada = true;
                            varMyTemporariaAtribuicao = v;
                        }  
                   } 
                }else{
                    for (VarMy v: lista) {
                        if(v.getNome().equals(token.getLexeme())){
                            v.setUtilizada(Boolean.TRUE);
                            verificaDeclarada = true;
                            //varMy = v;
                        }  
                    }
                    if(!verificaDeclarada){
                        VarMy varMylo = new VarMy();
                        varMylo.setNome(token.getLexeme());
                        varMylo.setUtilizada(Boolean.TRUE);
                        listaVariaveisNDeclarada.add(varMylo);
                    } 
                }
                
                break;     
            case 5 : 
                    tipoInput = true;
                break;     
            case 6 : 
                    tipoOutput = true;
                break;
            case 7 : 
                 semanticTable = new  SemanticTable();
                 disparoLocal = semanticTable.INT;
                 for (VarMy v: lista) {
                    if(v.getNome().equals(varMyTemporariaAtribuicao.getNome())){
                        v.setCompativel(semanticTable.atribType(v.getTipoNumerico(),semanticTable.INT));
                        //System.out.println("Teste Int:  "+v.getNome() +" - "+v.getCompativel());
                    }
                 }
                 
                break;
                
           case 8 : 
                 semanticTable = new  SemanticTable();
                 disparoLocal = semanticTable.FLO;
                 for (VarMy v: lista) {
                    if(v.getNome().equals(varMyTemporariaAtribuicao.getNome())){
                        v.setCompativel(semanticTable.atribType(v.getTipoNumerico(),semanticTable.FLO));
                        //System.out.println("Teste Float:  "+v.getNome() +" - "+v.getCompativel());
                    }
                 }
                break;
                    
           case 9 : 
                 semanticTable = new  SemanticTable();
                 disparoLocal = semanticTable.STR;
                 for (VarMy v: lista) {
                    if(v.getNome().equals(varMyTemporariaAtribuicao.getNome())){
                        v.setCompativel(semanticTable.atribType(v.getTipoNumerico(),semanticTable.STR));
                        //System.out.println("Teste String:  "+v.getNome() +" - "+v.getCompativel());
                    }
                 }
                break;
               
           case 14 : // +
               semanticTable = new  SemanticTable();
               verificaOperacoes.setOperacao(semanticTable.SUM);
               break;
           case 15 : // - 
               semanticTable = new  SemanticTable();
               verificaOperacoes.setOperacao(semanticTable.SUB);
               break;
           case 16 : // *
               semanticTable = new  SemanticTable();
               verificaOperacoes.setOperacao(semanticTable.MUL);
               break;     
           case 17 :// /
               semanticTable = new  SemanticTable();
               verificaOperacoes.setOperacao(semanticTable.DIV);
               break;
               
           case 18 :
               
               break;     
           case 19 :
               
               break;         
           case 20 :
               
               break;     
           case 21 :
               semanticTable = new  SemanticTable();
               verificaOperacoes = new VerificaOperacoes();
               if(disparoLocal == 0) verificaOperacoes.setTipo1(semanticTable.INT); // int
               if(disparoLocal == 1) verificaOperacoes.setTipo1(semanticTable.FLO); // float
               if(disparoLocal == 3) verificaOperacoes.setTipo1(semanticTable.STR); //string
               break;
           case 22 :
               semanticTable = new  SemanticTable();
               verificaOperacoes = new VerificaOperacoes();
               if(disparoLocal == 0) verificaOperacoes.setTipo1(semanticTable.INT); // int
               if(disparoLocal == 1) verificaOperacoes.setTipo1(semanticTable.FLO); // float
               if(disparoLocal == 3) verificaOperacoes.setTipo1(semanticTable.STR); //string
               break;     
           case 23 :
               semanticTable = new  SemanticTable();
               verificaOperacoes = new VerificaOperacoes();
               if(disparoLocal == 0) verificaOperacoes.setTipo1(semanticTable.INT); // int
               if(disparoLocal == 1) verificaOperacoes.setTipo1(semanticTable.FLO); // float
               if(disparoLocal == 3) verificaOperacoes.setTipo1(semanticTable.STR); //string
               break;
               
               
           case 24 :
               semanticTable = new  SemanticTable();
               if(disparoLocal == 0) verificaOperacoes.setTipo2(semanticTable.INT); // int
               if(disparoLocal == 1) verificaOperacoes.setTipo2(semanticTable.FLO); // float
               if(disparoLocal == 3) verificaOperacoes.setTipo2(semanticTable.STR); //string
               
               int resultado = semanticTable.resultType(verificaOperacoes.getTipo1(),verificaOperacoes.getTipo2(),verificaOperacoes.getOperacao());
               
               if(resultado != 0){
                   verificaOperacoes.setSeErrou(resultado);
                   listVO.add(verificaOperacoes);
               }
               
               break;     
           case 25 :
               semanticTable = new  SemanticTable();
               if(disparoLocal == 0) verificaOperacoes.setTipo2(semanticTable.INT); // int
               if(disparoLocal == 1) verificaOperacoes.setTipo2(semanticTable.FLO); // float
               if(disparoLocal == 3) verificaOperacoes.setTipo2(semanticTable.STR); //string
               
               int resultado2 = semanticTable.resultType(verificaOperacoes.getTipo1(),verificaOperacoes.getTipo2(),verificaOperacoes.getOperacao());
               
               if(resultado2 != 0){
                   verificaOperacoes.setSeErrou(resultado2);
                   listVO.add(verificaOperacoes);
               }
               
               break;
           case 26 :
               semanticTable = new  SemanticTable();
               if(disparoLocal == 0) verificaOperacoes.setTipo2(semanticTable.INT); // int
               if(disparoLocal == 1) verificaOperacoes.setTipo2(semanticTable.FLO); // float
               if(disparoLocal == 3) verificaOperacoes.setTipo2(semanticTable.STR); //string
               
               int resultado3 = semanticTable.resultType(verificaOperacoes.getTipo1(),verificaOperacoes.getTipo2(),verificaOperacoes.getOperacao());
               
               if(resultado3 != 0){
                   verificaOperacoes.setSeErrou(resultado3);
                   listVO.add(verificaOperacoes);
               } 
              break;
               
        }
    }	
}
