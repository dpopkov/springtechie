import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AddPostService} from "../add-post.service";
import {PostPayload} from "../post-payload";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  post: PostPayload;
  permaLink: Number;

  constructor(private router: ActivatedRoute, private postService: AddPostService) {
  }

  ngOnInit(): void {
    this.router.params.subscribe(params => {
      this.permaLink = params['id'];
    })

    this.postService.getPost(this.permaLink).subscribe((data: PostPayload) => {
      this.post = data;
    }, (err: any) => {
      console.log('Get post failure response');
    });
  }

}