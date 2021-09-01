import { RoomService } from './../room.service';
import { Room } from './../room';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-room',
  templateUrl: './update-room.component.html',
  styleUrls: ['./update-room.component.css']
})
export class UpdateRoomComponent implements OnInit {

  id!:number;
  room!:Room;
  submitted=false;

  constructor(private route:ActivatedRoute,private router:Router,private roomService:RoomService) { }

  ngOnInit(){
    this.room = new Room();
    this.id = this.route.snapshot.params['id'];
    this.roomService.getRoom(this.id).subscribe(data=>{
      console.log(data);
      this.room=data;
    },
      (error: any)=>console.log(error)
    );
  }
  updateRoom(){
    this.roomService.updateRoom(this.id,this.room).subscribe((data: any)=>console.log(data),(error: any)=>console.log(error));
    this.room = new Room();
    this.gotoList();
  }
  onSubmit(){
    this.updateRoom();
  }
  gotoList(){
    this.router.navigate(['/room']);
  }

}
