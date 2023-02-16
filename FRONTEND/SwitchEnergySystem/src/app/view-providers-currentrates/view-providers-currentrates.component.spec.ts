import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewProvidersCurrentratesComponent } from './view-providers-currentrates.component';

describe('ViewProvidersCurrentratesComponent', () => {
  let component: ViewProvidersCurrentratesComponent;
  let fixture: ComponentFixture<ViewProvidersCurrentratesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewProvidersCurrentratesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewProvidersCurrentratesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
