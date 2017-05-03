/**
 * Created by medsog on 01/05/2017.
 */

export class LignesDeVente {
//la representation js de la table lignevente
    public id:number;
    public id_entete:number;
    public id_article_gamme:number;
    public n_serie:string;
    public pu_ht:number = 0;
    public qte:number = 0;
    public tva:number = 0.2;
    public pt_ht:number = 0;
    public pt_ttc:number = 0;
    public remise:number = 0;
    public cmup:number = 0;
}
