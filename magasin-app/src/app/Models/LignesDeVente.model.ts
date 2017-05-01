/**
 * Created by medsog on 01/05/2017.
 */

export class LignesDeVente {
//la representation js de la table lignevente
    id:number;
    id_entete:number;
    id_article_gamme:number;
    n_serie:string;
    pu_ht:number = 0;
    qte:number = 0;
    tva:number = 0.2;
    pt_ht:number = 0;
    pt_ttc:number = 0;
    remise:number = 0;
    cmup:number = 0;
}
