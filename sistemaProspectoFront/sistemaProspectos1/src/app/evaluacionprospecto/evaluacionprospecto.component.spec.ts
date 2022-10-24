import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EvaluacionprospectoComponent } from './evaluacionprospecto.component';

describe('EvaluacionprospectoComponent', () => {
  let component: EvaluacionprospectoComponent;
  let fixture: ComponentFixture<EvaluacionprospectoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EvaluacionprospectoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EvaluacionprospectoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
