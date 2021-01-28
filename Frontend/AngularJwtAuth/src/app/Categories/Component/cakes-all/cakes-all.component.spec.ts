import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CakesAllComponent } from './cakes-all.component';

describe('CakesAllComponent', () => {
  let component: CakesAllComponent;
  let fixture: ComponentFixture<CakesAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CakesAllComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CakesAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
