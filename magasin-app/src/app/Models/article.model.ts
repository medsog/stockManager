export class article.model.ts {
  constructor(
    public id_article: number,
	public Code_Article: string,
	public Intitule_Article: string,
	public Description: string,
	public Famille: number,
	public Prix_Achat: number,
	public Prix_Vente: number,
	public Unite: number,
	public Code_Barre: string,
	public Tva: number,
	public remise: number,
	public Qte: number,
	public Cmup: number,
	public file: string
  ) {  }
}