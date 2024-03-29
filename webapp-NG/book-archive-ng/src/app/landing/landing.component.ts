import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'ba-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit{
  pageTitle: string = 'Archive';

  constructor(private route: ActivatedRoute,
              private router: Router){ }
  ngOnInit(): void {
    this.pageTitle = 'Archive';
  }

  onClick(): void {
    this.router.navigate(['/list']);
  }

}
