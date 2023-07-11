import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any, filteredString: string) {
    if(value.length === 0 || filteredString === ''){
      return value;
    }
   
    const appoint = [];
    for (const a of value){
      if(a['doctorName'] === filteredString){
        appoint.push(a);
      }
    }
    return appoint;
  }
  
}
