import { MagasinAppPage } from './app.po';

describe('magasin-app App', () => {
  let page: MagasinAppPage;

  beforeEach(() => {
    page = new MagasinAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
