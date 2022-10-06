import { atom } from 'recoil';
import { storge } from '../utils/storge';
import { MENU } from '../constants';

const sessionStorageEffect =
  (key) =>
  ({ setSelf, onSet }) => {
    const data = storge.getData(key);
    if (data) setSelf(data);
    onSet((newData) => {
      storge.setData(key, newData);
    });
  };

const atoms = {
  menuQuery: atom({ key: 'menu', default: MENU[0].query }),

  isLogin: atom({
    key: 'isLogin',
    default: { state: false, type: null },
    effects: [sessionStorageEffect('isLogin')],
  }),

  modal: atom({
    key: 'modal',
    default: { food: false, order: false, email: false },
  }),

  menuOrder: atom({
    key: 'menuOrder',
    default: [
      { storeId: null, name: null, price: null, info: null, img: null },
    ],
  }),

  orderList: atom({
    key: 'orderList',
    default: [],
    effects: [sessionStorageEffect('orderList')],
  }),
};

export { atoms };