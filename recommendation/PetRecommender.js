import path from 'path';
import fs from 'fs';
import { fileURLToPath } from 'url';

// 현재 파일의 경로를 가져오는 코드 (CommonJS의 `__filename`, `__dirname` 대체)
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

export class PetRecommender {
  constructor() {
    this.customers = [];
  }
  recommendPet(customer) {
    const { lifestyle, housing, familyMembers } = customer; //분해 할당
    if (
      lifestyle === '활동적' &&
      housing === '단독주택' &&
      familyMembers === '어린이 없음'
    ) {
      customer.recommenedPet = '골든리트리버';
    } else if (
      lifestyle === '조용한' &&
      housing === '아파트' &&
      familyMembers === '어린이 있음'
    ) {
      customer.recommenedPet = '고양이';
    }
    this.customers.push(customer);
  }
  saveToFile() {
    fs.promises.appendFile(
      `${__dirname}/pet_recommendations.json`,
      this.customers
    );
  }
}
