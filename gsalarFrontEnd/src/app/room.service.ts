import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl='http://localhost:8082/api/v1/room';

  constructor(private http: HttpClient) { }

  getRoom(id:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createRoom(room:Object):Observable<object>{
    return this.http.post(`${this.baseUrl}`,room);
  }
  updateRoom(id:number,value: any):Observable<object>{
    return this.http.put(`${this.baseUrl}/${id}`,value)
  }

  deleteRoom(id:number):Observable<any>{
    return this.http.delete(`${this.baseUrl}/${id}`,{responseType:'text'});
  }

  getRoomList():Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }
}
